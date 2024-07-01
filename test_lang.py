import httpx
from prefect import flow, task, get_run_logger
from langchain_community.document_loaders import UnstructuredMarkdownLoader


@task(retries=2)
def check_file(filename: str):
    logger = get_run_logger()
    logger.info("%s filename 🤓:", filename)
    LOADER_DICT = {
        "UnstructuredHTMLLoader": ['.html'],
        "UnstructuredMarkdownLoader": ['.md'],
        "JSONLoader": [".json"],
        "JSONLinesLoader": [".jsonl"],
        "CSVLoader": [".csv"],
        "RapidOCRPDFLoader": [".pdf"],
        "RapidOCRLoader": ['.png', '.jpg', '.jpeg', '.bmp'],
        "UnstructuredEmailLoader": ['.eml', '.msg'],
        "UnstructuredEPubLoader": ['.epub'],
        "UnstructuredExcelLoader": ['.xlsx', '.xls'],
        "NotebookLoader": ['.ipynb'],
        "UnstructuredODTLoader": ['.odt'],
        "PythonLoader": ['.py'],
        "UnstructuredRSTLoader": ['.rst'],
        "UnstructuredRTFLoader": ['.rtf'],
        "SRTLoader": ['.srt'],
        "TomlLoader": ['.toml'],
        "UnstructuredTSVLoader": ['.tsv'],
        "UnstructuredWordDocumentLoader": ['.docx', '.doc'],
        "UnstructuredXMLLoader": ['.xml'],
        "UnstructuredPowerPointLoader": ['.ppt', '.pptx'],
        "UnstructuredFileLoader": ['.txt'],
    }

    # Get the file extension
    file_ext = filename.split('.')[-1].lower()

    # Check if the extension is in the supported extensions
    for loader, ext_list in LOADER_DICT.items():
        if file_ext in ext_list:
            return loader  # Return the loader if extension is supported

    return False  # Return False if extension is not supported


@task(retries=2)
def transformer_file(filename: str, loader: str):
    if loader is not False:
        return 1
    else:
        return 1

@task(retries=2)
def data_loader(filename: str):
    from prefect.filesystems import LocalFileSystem

    local_file_system_block = LocalFileSystem.load("test-windows")

    logger = get_run_logger()
    logger.info("%s get_directory 🤓:", local_file_system_block.get_directory())
    loader = UnstructuredMarkdownLoader(filename)
    data = loader.load()
    return data



@flow(log_prints=True)
def data_process(filename: str = "PrefectHQ/prefect"):

    loader = check_file.submit(filename)
    # if loader:
    #
    #     print(f"File '{filename}' can be loaded with '{loader}'.")
    # else:
    #     flag = None
    #     print(f"File extension not supported for '{filename}'.")
    flag = transformer_file.submit(filename, loader, wait_for=[loader])
    data = None


    # if flag:
    #     data = data_loader("./test.md", wait_for=[flag])
    #     logger = get_run_logger()
    #     logger.info("%s data statistics 🤓:", data)
    # else:
    #     print(f"File extension not supported for '{filename}'.")
    # return data

    if flag:
        future = data_loader.submit("./test.md", wait_for=[flag],return_state=True)
        logger = get_run_logger()
        logger.info("%s data statistics 🤓:", future.result())
    else:
        print(f"File extension not supported for '{filename}'.")
    return future.result()
if __name__ == "__main__":
    data_process(filename="./test.pdf")
