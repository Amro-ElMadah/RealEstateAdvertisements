package com.avivgroup.realestateadvertisements.utils

import com.avivgroup.realestateadvertisements.data.remote.network.response.RealEstateAdvertisementsResponse
import com.google.gson.Gson

object FakeRealEstatesListData {
    private const val response = """
{
  "items": [
    {
      "bedrooms": 4,
      "city": "Villers-sur-Mer",
      "id": 1,
      "area": 250.0,
      "url": "https://v.seloger.com/s/crop/590x330/visuels/1/7/t/3/17t3fitclms3bzwv8qshbyzh9dw32e9l0p0udr80k.jpg",
      "price": 1500000.0,
      "professional": "GSL EXPLORE",
      "propertyType": "Maison - Villa",
      "offerType": 1,
      "rooms": 8
    },
    {
      "bedrooms": 7,
      "city": "Deauville",
      "id": 2,
      "area": 600.0,
      "url": "https://v.seloger.com/s/crop/590x330/visuels/2/a/l/s/2als8bgr8sd2vezcpsj988mse4olspi5rfzpadqok.jpg",
      "price": 3500000.0,
      "professional": "GSL STICKINESS",
      "propertyType": "Maison - Villa",
      "offerType": 2,
      "rooms": 11
    },
    {
      "city": "Bordeaux",
      "id": 3,
      "area": 550.0,
      "price": 3000000.0,
      "professional": "GSL OWNERS",
      "propertyType": "Maison - Villa",
      "offerType": 1,
      "rooms": 7
    },
    {
      "city": "Nice",
      "id": 4,
      "area": 250.0,
      "url": "https://v.seloger.com/s/crop/590x330/visuels/1/9/f/x/19fx7n4og970dhf186925d7lrxv0djttlj5k9dbv8.jpg",
      "price": 5000000.0,
      "professional": "GSL CONTACTING",
      "offerType": 3,
      "propertyType": "Maison - Villa"
    }
  ],
  "totalCount": 4
}
"""

    val realEstateAdvertisementsResponse = Gson().fromJson(response, RealEstateAdvertisementsResponse::class.java)
}