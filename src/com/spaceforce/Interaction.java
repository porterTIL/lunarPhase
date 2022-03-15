package com.spaceforce;

public interface Interaction {
    enum CommandList {talk("chat", "communicate"), look(), pickup, go, use, drop;
        String[] synonyms;
        CommandList(String... synonyms){
            this.synonyms = synonyms;
        }
        public void execute(Interaction interactable){
            if(this.name().equals(talk.name())){
                interactable.talk();
            } // for(synonym :talk)
            //talk (and other commands) return true or false if they were ran on a successful target.
            //if(talk was true){changeGame(verb, noun)}
        }
    }

    void talk();
    void look();
    void pickup();
    void go();
    void use();
    void drop();
}