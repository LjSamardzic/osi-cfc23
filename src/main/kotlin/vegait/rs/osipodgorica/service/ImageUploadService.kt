package vegait.rs.osipodgorica.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

@Service
class ImageUploadService(
    @Value("\${app.file.upload-dir:./uploads}")
    var uploadDir: String
) {
    val rootLocation: Path = Paths.get(uploadDir)

    fun store(file: MultipartFile, folderName: String): String {
        // file name format: timestamp_originalName
        val name: String = System.currentTimeMillis().toString() + "_" + file.originalFilename
        val destinationFile: Path = this.rootLocation.resolve(Paths.get("$folderName/$name")).normalize()

        try {
            Files.createDirectories(this.rootLocation.resolve("$folderName/$name"))
            val inputStream: InputStream = file.inputStream
            Files.copy(inputStream, destinationFile.toAbsolutePath(), StandardCopyOption.REPLACE_EXISTING)
        } catch (e: IOException) {
            throw RuntimeException("There was an error uploading the file to $folderName/$name", e)
        }

        return destinationFile.toString()
    }
}