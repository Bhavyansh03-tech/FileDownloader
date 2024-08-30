# File Downloader App

This Android app demonstrates how to implement a file download manager using the **Ketch** library. The app supports features like downloading, pausing, resuming, retrying, and deleting downloads. It also provides real-time updates on download progress, status, and file size.

## Features

- Download files with a custom file name and path.
- Monitor download progress and status.
- Pause, resume, cancel, and retry downloads.
- Display downloaded file size in megabytes.
- Delete downloaded files and reset download progress.

## Screenshot

<img src="" alt="First Screenshot" style="width: 200px; height: auto; margin-right: 10px;">
<img src="" alt="Second Screenshot" style="width: 200px; height: auto;">


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
