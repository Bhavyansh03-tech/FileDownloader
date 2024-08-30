package com.example.fileDownloader

import java.util.Locale

// Convert bytes to megabytes
fun calculateDownloadedMegabytes(progress: Int, total: Long): String {
    val downloadedBytes = progress / 100.0 * total
    return getTwoDecimals(value = downloadedBytes / (1024.0 * 1024.0))
}

fun getTwoDecimals(value: Double): String {
    return String.format(Locale.ROOT, "%.2f", value)
}