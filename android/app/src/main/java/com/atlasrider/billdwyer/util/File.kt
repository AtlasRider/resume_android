package com.atlasrider.billdwyer.util

import android.content.res.AssetManager
import java.io.IOException
import java.io.InputStream

class File {
    companion object {
        @Throws(IOException::class)
        fun readAsset(assetManager: AssetManager, fileName: String): String {
            val inputStream: InputStream = assetManager.open(fileName)
            return inputStream.bufferedReader().use{it.readText()}
        }
    }
}