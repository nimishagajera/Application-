package com.app.test.model


data class ArticleResponse(
    val resourceType: String,
    val articlesCount: Int,
    val _links: Links,
    val _embedded: Embedded
)

data class Embedded(
    val filters: List<Filter>,
    val articles: List<Article>
)

data class Filter(
    val values: List<Value>,
    val id: String,
    val priority: Int,
    val title: String,
    val _metadata: Metadata,
    val min: Int,
    val max: Int,
    val currentMin: Int,
    val currentMax: Int,
    val unit: String
)

data class Value(
    val id: String,
    val priority: Int,
    val title: String,
    val _metadata: Metadata
)

data class Metadata(
    val type: String
)

data class Article(
    val description: Any,
    val prevPrice: Any,
    val manufacturePrice: Any,
    val delivery: Delivery,
    val brand: Brand,
    val media: List<Media>,
    val assemblyService: Any,
    val availability: Any,
    val url: Any,
    val energyClass: Any,
    val sku: String,
    val title: String,
    val price: Price,
    val _metadata: Metadata,
    val _links: Links
)

data class Delivery(
    val time: Time,
    val type: String,
    val terms: Any,
    val deliveredBy: Any,
    val text: String,
    val typeLabelLink: String
)

data class Time(
    val renderAs: String,
    val amount: String,
    val units: String
)

data class Links(
    val self: Self,
    val webShopUrl: WebShopUrl
)

data class Self(
    val href: String
)

data class WebShopUrl(
    val href: Any
)

data class Media(
    val uri: String,
    val mimeType: String,
    val type: Any,
    val priority: Int,
    val size: Any
)

data class Price(
    val amount: String,
    val currency: String,
    val isRecommendedRetailPrice: Boolean
)

data class Brand(
    val id: String,
    val title: String,
    val logo: List<String>,
    val description: String
)

data class Next(
    val href: String
)
