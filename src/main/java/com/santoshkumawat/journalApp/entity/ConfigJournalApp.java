package com.santoshkumawat.journalApp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "config_journal")
@Data
@NoArgsConstructor
public class ConfigJournalApp {
    private String key;
    private String value;
}