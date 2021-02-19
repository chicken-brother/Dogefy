package com.thedogenetwork.dogefy.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.thedogenetwork.dogefy.data.entities.Song
import com.thedogenetwork.dogefy.other.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDatabase {
    // Gets all songs from database.
    // In real app you should use pagination
    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song>{
        return try{
            songCollection.get().await().toObjects(Song::class.java)
        }catch (e: Exception){
            emptyList()
        }
    }
}