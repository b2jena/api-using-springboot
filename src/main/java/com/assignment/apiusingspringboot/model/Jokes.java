package com.assignment.apiusingspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Jokes {
    private Boolean error;
    private String category;
    private String type;
    private String setup;
    private String delivery;
    private Flags flags;
    private Long id;
    private Boolean safe;
    private String lang;

    @Override
    public String toString() {
        return "Jokes{" +
                "error='" + error + '\'' +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", setup='" + setup + '\'' +
                ", delivery='" + delivery + '\'' +
                ", flags=" + flags +
                ", id=" + id +
                ", safe=" + safe +
                ", lang='" + lang + '\'' +
                '}';
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Flags {
        Boolean nsfw;
        Boolean religious;
        Boolean political;
        Boolean racist;
        Boolean sexist;
        Boolean explicit;

        @Override
        public String toString() {
            return "Flags{" +
                    "nsfw='" + nsfw + '\'' +
                    ", religious='" + religious + '\'' +
                    ", political=" + political +
                    ", racist=" + racist +
                    ", sexist=" + sexist +
                    ", explicit=" + explicit +
                    '}';
        }
    }
}
