package com.horux.extensions

import java.io.File
import java.util.*

val imageFileExtensions = listOf(
    "JPEG", "JPG",
    "PNG",
    "GIF",
    "BMP",
    "TIFF", "TIF",
    "PSD",
    "SVG",
    "RAW",
    "ICO",
    "HEIF", "HEIC",
    "WEBP",
    "JP2",
    "PICT",
    "PBM",
    "PGM",
    "PPM",
    "XBM",
    "XPM",
    "DNG",
    "CR2",
    "NEF",
    "ARW",
    "ORF",
    "RW2"
)


fun File?.isNullOrEmpty() = this == null || this.length() == 0L

fun File?.getExtension() : String = this?.absolutePath?.ifNotNullOrEmpty<String> {
    it.substring(it.lastIndexOf('.') + 1).lowercase(Locale.getDefault())
}?.doElse {
    ""
} ?: ""

fun File?.isImage(): Boolean = imageFileExtensions.contains(this?.getExtension()?.uppercase())