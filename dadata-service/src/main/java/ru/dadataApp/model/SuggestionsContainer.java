package ru.dadataApp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SuggestionsContainer {
    private List<Suggestions> suggestions;
}