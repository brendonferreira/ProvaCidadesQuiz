package com.blee.provacidadesquiz;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;


class City {
    String name;
    int resourceImage;

    public City(String name, int resourceImage) {
        this.name = name;
        this.resourceImage = resourceImage;
    }
}

public class Quiz {



    static HashMap<String, City> cities = new HashMap<String, City>();

    City cidadeSorteada;
    Question questionView;
    int pontos = 0;

    static {
        cities = new HashMap<>();
        cities.put("São Paulo", new City( "São Paulo", R.drawable.image1 ) ) ;
        cities.put("Rio de Janeiro", new City( "Rio de Janeiro", R.drawable.image2 ) ) ;
        cities.put("Curitiba", new City( "Curitiba", R.drawable.image3 ) ) ;
        cities.put("Salvador", new City( "Salvador", R.drawable.image4 ) ) ;
        cities.put("Brasília", new City( "Brasília", R.drawable.image5 ) ) ;
        cities.put("Paris", new City( "Paris", R.drawable.image6 ) ) ;
        cities.put("Tóquio", new City( "Tóquio", R.drawable.image7 ) ) ;
        cities.put("Barcelona", new City( "Barcelona", R.drawable.image8 ) ) ;
        cities.put("Las Vegas", new City( "Las Vegas", R.drawable.image9) ) ;
        cities.put("Montreal", new City( "Montreal", R.drawable.image10) ) ;

    }

    public Quiz(Question question) {
        questionView = question;
    }

    static Collection<City> getCities() {
        return cities.values();
    }

    public void next() {
        cidadeSorteada = getRandomCity();
        questionView.setQuizQuestion(cidadeSorteada);
    }

    public City getRandomCity() {
        Collection<City> c = Quiz.getCities();
        int random = (int) (Math.random() * c.size());
        Iterator<City> it = c.iterator();
        for (int i = 0; i < random; i++) {
            it.next();
        }
        return it.next();
    }


    public boolean isAnswerRight(String cityName) {
        return cidadeSorteada.name.equals(cityName);
    }

    public void punctuate() {
        pontos += 25;
    }

    public int getResult() {
        return pontos;
    }
}
