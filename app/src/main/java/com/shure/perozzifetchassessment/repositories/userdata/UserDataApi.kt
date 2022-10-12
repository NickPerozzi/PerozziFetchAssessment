package com.shure.perozzifetchassessment.repositories.userdata

import com.shure.perozzifetchassessment.model.User
import retrofit2.Response
import retrofit2.http.GET

interface UserDataApi {

    @GET("/hiring.json")
    suspend fun getUserData(): Response<List<User>>

}