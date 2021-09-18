package ru.sber.nio

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.File

internal class GrepTest {

    private val grep = Grep()

    @Test
    fun `check grep with given example`() {
        val resultFile = File(grep.resultFileName)

        grep.find("22/Jan/2001:14:27:46")

        assertTrue(resultFile.exists())
        assertTrue(resultFile.isFile)
        assertEquals(
            "22-01-2001-1.log : 3 : 192.168.1.1 - - [22/Jan/2001:14:27:46 +0000] \"POST /files HTTP/1.1\" 200 - \"-\"",
            String(resultFile.readBytes()).trim()
        )
    }

}