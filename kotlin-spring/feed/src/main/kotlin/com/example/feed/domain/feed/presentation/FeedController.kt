package com.example.feed.domain.feed.presentation

import com.example.feed.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.feed.domain.feed.presentation.dto.response.QueryFeedsResponse
import com.example.feed.domain.feed.service.CreateFeedService
import com.example.feed.domain.feed.service.QueryFeedsService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/feeds")
@RestController
class FeedController(
    private val createFeedService: CreateFeedService,
    private val queryFeedsService: QueryFeedsService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(@RequestBody @Valid request: CreateFeedRequest) =
        createFeedService.execute(request)

    @GetMapping
    fun get(): List<QueryFeedsResponse> = queryFeedsService.execute()

}