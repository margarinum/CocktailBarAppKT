package com.example.helloworld

import java.sql.DriverManager

data class GetData (val conn_str: String) {

    fun main(){
        val jdbcUrl = "jdbc:postgresql://localhost:5432/postgres"

        val connection = DriverManager
            .getConnection(jdbcUrl, "postgres", "postgres")

        val query = connection.prepareStatement("SET search_path TO cocktail_bar")
    }
}