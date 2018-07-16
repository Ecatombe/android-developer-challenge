package com.marvel.fabioinsolia.streetbees.data.remote

interface IAPIProvider {
  fun create(): IAPIClient
}