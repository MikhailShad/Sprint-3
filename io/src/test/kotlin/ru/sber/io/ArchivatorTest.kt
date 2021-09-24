package ru.sber.io

import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileInputStream
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class ArchivatorTest {

    private val archiver: Archivator = Archivator()

    @Test
    fun `check zip and unzip`() {
        archiver.zipLogfile()
        archiver.unzipLogfile()

        val unzippedFile = File(archiver.unzippedLogFile)
        assertTrue { unzippedFile.exists() }

        val sourceContent = String(FileInputStream(archiver.logFile).readAllBytes())
        val resultContent = String(FileInputStream(unzippedFile).readAllBytes())
        assertEquals(sourceContent, resultContent)
    }
}