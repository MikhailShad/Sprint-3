package ru.sber.io

import java.io.File
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream

/**
 * Реализовать методы архивации и разархивации файла.
 * Для реализиации использовать ZipInputStream и ZipOutputStream.
 */
class Archivator {
    private val bufferSize = 1024
    val logFile = "logfile.log"
    private val zipLogFile = "logfile.zip"
    val unzippedLogFile = "unzippedLogFile.log"

    /**
     * Метод, который архивирует файл logfile.log в архив logfile.zip.
     * Архив должен располагаться в том же каталоге, что и исходной файл.
     */
    fun zipLogfile() {
        File(logFile).inputStream().use { input ->
            ZipOutputStream(FileOutputStream(zipLogFile)).use { output ->
                val zipEntry = ZipEntry(logFile)
                output.putNextEntry(zipEntry)
                input.copyTo(output, bufferSize)
                output.closeEntry()
            }
        }
    }

    /**
     * Метод, который извлекает файл из архива.
     * Извлечь из архива logfile.zip файл и сохарнить его в том же каталоге с именем unzippedLogfile.log
     */
    fun unzipLogfile() {
        ZipFile(zipLogFile).use { zip ->
            zip.getInputStream(zip.getEntry(logFile)).use { input ->
                File(unzippedLogFile).outputStream().use { output ->
                    input.copyTo(output)
                }
            }
        }
    }
}