package com.dimax.models.api;

import com.dimax.entities.User;

import java.util.List;

public record MyResponse(List<User> users, int total) {
}
