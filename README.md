# File Downloader App

This Android app demonstrates how to implement a file download manager using the **Ketch** library. The app supports features like downloading, pausing, resuming, retrying, and deleting downloads. It also provides real-time updates on download progress, status, and file size.

## Features

- Download files with a custom file name and path.
- Monitor download progress and status.
- Pause, resume, cancel, and retry downloads.
- Display downloaded file size in megabytes.
- Delete downloaded files and reset download progress.

## Screenshot

<div style="display: flex; justify-content: center; align-items: center;">
    <img src="https://github.com/user-attachments/assets/c07c52b1-4cc2-4f3f-aa37-c6c37df2d824" alt="First Screenshot" style="width: 200px; height: auto; margin-right: 10px;">
    <img src="https://github.com/user-attachments/assets/0f7bc44f-f6a8-4836-9c3d-2e4de62fb4c2" alt="Second Screenshot" style="width: 200px; height: auto; margin-right: 10px;">
    <img src="https://github.com/user-attachments/assets/55daa80a-86ba-41d4-87e4-a3635f83b005" alt="Third Screenshot" style="width: 200px; height: auto;">
</div>

<div style="display: flex; justify-content: center; align-items: center;">
    <img src="https://github.com/user-attachments/assets/0553b452-fade-4ef8-b9f7-01b1a919d75b" alt="Fourth Screenshot" style="width: 200px; height: auto; margin-right: 10px;">
    <img src="https://github.com/user-attachments/assets/7070ee98-4b95-4165-8ded-02add2151c52" alt="Fifth Screenshot" style="width: 200px; height: auto;">
</div>

## Code Overview

The main implementation is in the `MainActivity.kt` file. Below is a highlighted section of the code that manages the download process:

```kotlin
// Ketch initialization
ketch = Ketch.builder()
    .setNotificationConfig(
        NotificationConfig(
            enabled = true,
            smallIcon = R.drawable.ic_launcher_foreground
        )
    )
    .setDownloadConfig(
        DownloadConfig(
            connectTimeOutInMs = 15000,
            readTimeOutInMs = 15000
        )
    )
    .build(this)

// Start the download
ketch.download(
    tag = FILE_TAG,
    url = DOWNLOAD_URL,
    fileName = FILE_NAME,
    path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).path // Saving downloaded file in specific folder
)

// Monitor the download progress
ketch.observeDownloadByTag(tag = FILE_TAG)
    .collect { downloadModel ->
        for (model in downloadModel) {
            status = model.status
            progress = model.progress
            total = model.total
        }
    }

// Convert bytes to megabytes
fun calculateDownloadedMegabytes(progress: Int, total: Long): String {
    val downloadedBytes = progress / 100.0 * total
    return getTwoDecimals(value = downloadedBytes / (1024.0 * 1024.0))
}
```

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any improvements or bug fixes.

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Create a new Pull Request.

## Contact

For questions or feedback, please contact [@Bhavyansh03-tech](https://github.com/Bhavyansh03-tech) on GitHub or connect with me on [LinkedIn](https://www.linkedin.com/in/bhavyansh03/).

---
