package com.assignment.apiusingspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Jokes {
    Boolean error;
    String category;
    String type;
    String setup;
    String delivery;
    Flags flags;
    Long id;
    Boolean safe;
    String lang;

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

    public static class Flags {
        Boolean nsfw;
        Boolean religious;
        Boolean political;
        Boolean racist;
        Boolean sexist;
        Boolean explicit;

        public Flags(Boolean nsfw, Boolean religious, Boolean political, Boolean racist, Boolean sexist, Boolean explicit) {
            this.nsfw = nsfw;
            this.religious = religious;
            this.political = political;
            this.racist = racist;
            this.sexist = sexist;
            this.explicit = explicit;
        }

        public Boolean getNsfw() {
            return nsfw;
        }

        public void setNsfw(Boolean nsfw) {
            this.nsfw = nsfw;
        }

        public Boolean getReligious() {
            return religious;
        }

        public void setReligious(Boolean religious) {
            this.religious = religious;
        }

        public Boolean getPolitical() {
            return political;
        }

        public void setPolitical(Boolean political) {
            this.political = political;
        }

        public Boolean getRacist() {
            return racist;
        }

        public void setRacist(Boolean racist) {
            this.racist = racist;
        }

        public Boolean getSexist() {
            return sexist;
        }

        public void setSexist(Boolean sexist) {
            this.sexist = sexist;
        }

        public Boolean getExplicit() {
            return explicit;
        }

        public void setExplicit(Boolean explicit) {
            this.explicit = explicit;
        }

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
