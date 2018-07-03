import db.DBPokemon;
import db.DBTrainer;
import models.Pokemon;
import models.Trainer;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Pokemon pokemon1 = new Pokemon("Charmander", "Fire");
        DBPokemon.save(pokemon1);

        Pokemon pokemon2 = new Pokemon("Squirtle", "Water");
        DBPokemon.save(pokemon2);

        Pokemon pokemon3 = new Pokemon("Bulbasaur", "Grass");
        DBPokemon.save(pokemon3);

        Pokemon pokemon4 = new Pokemon("Mr. Mime", "Psychic");
        DBPokemon.save(pokemon4);

        Trainer trainer1 = new Trainer("Ash", "Ketchum", 18);
        DBTrainer.save(trainer1);

        Trainer trainer2 = new Trainer("Misty", "Williams", 20);
        DBTrainer.save(trainer2);

        Trainer trainer3 = new Trainer("Brock", "Harrison", 26);
        DBTrainer.save(trainer3);

        Trainer trainer4 = new Trainer("Richard", "Badtrainer", 18);
        DBTrainer.save(trainer4);

        Pokemon squirtle = DBPokemon.find(pokemon2.getId());

        List<Pokemon> allPokemon = DBPokemon.getAll();


    }

}
