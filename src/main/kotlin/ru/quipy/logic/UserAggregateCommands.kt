package ru.quipy.logic

import ru.quipy.api.UserRegisteredEvent
import ru.quipy.api.UserNameUpdatedEvent
import java.util.*


// Commands : takes something -> returns event
// Here the commands are represented by extension functions, but also can be the class member functions

fun UserAggregateState.register(nickname: String, email: String, userName: String, password: String): UserRegisteredEvent {
    if (userName.isNullOrBlank()) {
        throw IllegalArgumentException("Empty userName")
    }
    if (email.isNullOrBlank()) {
        throw IllegalArgumentException("Empty email")
    }
    if (password.isNullOrBlank()) {
        throw IllegalArgumentException("Empty password")
    }
    return UserRegisteredEvent(
        nickname = nickname,
        email = email,
        userName = userName,
        password = password,
    )
}

fun UserAggregateState.updateName(userName: String): UserNameUpdatedEvent {
    if (userName.isNullOrBlank()) {
        throw IllegalArgumentException("Empty userName")
    }
    return UserNameUpdatedEvent(nickname = this.getId(), userName = userName)
}