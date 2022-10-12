package com.shure.perozzifetchassessment.repositories.userdata

import android.util.Log
import com.shure.perozzifetchassessment.model.User
import retrofit2.HttpException
import java.io.IOException

val TAG = "UserDataRepository.kt"

object UserDataRepository {

    suspend fun getUserData(): List<User>? {
        val response = try {
            RetrofitInstance.api.getUserData()
        } catch (e: IOException) {
            Log.e(TAG, "No internet to pull json string")
            return null
        } catch (e: HttpException) {
            Log.e(TAG, "HttpException, unexpected response")
            return null
        }
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}