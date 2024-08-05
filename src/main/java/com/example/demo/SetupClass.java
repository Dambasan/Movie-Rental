package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SetupClass {

    @Autowired
    private MovieService movieService;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private ActorRepository actorRepository;

    @PostConstruct
    public void init() {
        Type aksiyon = typeRepository.save(new Type("Aksiyon"));
        Type bilimKurgu = typeRepository.save(new Type("Bilim Kurgu"));
        Type korku = typeRepository.save(new Type("Korku"));
        Type gerilim = typeRepository.save(new Type("Gerilim"));
        Type dram = typeRepository.save(new Type("Dram"));

        Actor DanielRadcliffe = actorRepository.save(new Actor("Daniel","Radcliffe","M","26-05-1996","İngilterede Doğup büyüdü", 28,"https://m.media-amazon.com/images/M/MV5BZmE0NzNiNzQtYTVlYS00MjljLWE4MTgtYzYxNjU2NjZkM2M4XkEyXkFqcGdeQXVyNjY5NDgzNjQ@._V1_.jpg"));
        Actor MorganFreeman = actorRepository.save(new Actor("Morgan","Freeman","M","21-01-1967","Siyahi Her Filmde Olan Adam",57,"https://m.media-amazon.com/images/M/MV5BMTc0MDMyMzI2OF5BMl5BanBnXkFtZTcwMzM2OTk1MQ@@._V1_FMjpg_UX1000_.jpg"));
        Actor LeonardoDicaprio = actorRepository.save(new Actor("Leonardo", "Dicaprio", "M", "13-04-1986","Popüler Film Yıldızı", 38,"https://m.media-amazon.com/images/M/MV5BMjI0MTg3MzI0M15BMl5BanBnXkFtZTcwMzQyODU2Mw@@._V1_FMjpg_UX1000_.jpg"));
        Actor TobinBell = actorRepository.save(new Actor("Tobin","Bell","M","23-5-1965", "I want to play game",59,"https://m.media-amazon.com/images/M/MV5BNjM5OTE1MjA3Nl5BMl5BanBnXkFtZTgwOTAxNjk4MDE@._V1_.jpg"));
        Actor PaulWalker = actorRepository.save(new Actor("Paul", "Walker","M","23-12-1985","Nissan GTR-34",39,"https://m.media-amazon.com/images/M/MV5BMjIwODc0OTk2Nl5BMl5BanBnXkFtZTcwOTQ5MDA0Mg@@._V1_FMjpg_UX1000_.jpg"));

        List<Actor> actorList1 = new ArrayList<>();
        actorList1.add(DanielRadcliffe);
        actorList1.add(MorganFreeman);
        actorList1.add(LeonardoDicaprio);
        actorList1.add(TobinBell);
        actorList1.add(PaulWalker);

        movieService.createMovie(new Movie("Esaretin Bedeli", "2000", "https://images.justwatch.com/poster/264367990/s718/esaretin-bedeli.jpg", "A Maine banker convicted of the murder of his wife and her lover in 1947 gradually forms a friendship over a quarter century with a hardened convict, while maintaining his innocence and trying to remain hopeful through simple compassion.", dram, 64, actorList1, 3.49 ));
        movieService.createMovie(new Movie("Harry Potter ve Felsefe Taşı", "2001", "https://upload.wikimedia.org/wikipedia/tr/e/e0/Harry_Potter_and_the_Sorcerer%27s_Stone_%28film%2C_2001%29.jpg", "Harry Potter", bilimKurgu,23,actorList1,5.49));
        movieService.createMovie(new Movie("Inception", "2012", "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_.jpg", "A thief who steals corporate secrets through the use of dream-sharing technology", bilimKurgu,13,actorList1,9.99));
        movieService.createMovie(new Movie("Testere", "2012", "https://upload.wikimedia.org/wikipedia/tr/3/34/Saw_poster.jpg", "Filmin hikayesi, bu iki adamın, köhne ve terk edilmiş bir yerde, ayakları zincirle bağlı bir halde uyanmalarıyla başlar.", gerilim,36,actorList1,2.49));
        movieService.createMovie(new Movie("Fast and Furious", "2010", "https://tr.web.img2.acsta.net/pictures/bzp/01/29173.jpg", "Hızlı ve Öfkeli'de Domenic Toretto, arabaların pahalı aksesuarlarını çalan bir çetenin baş üyesidir.", aksiyon, 25,actorList1,1.99));

    }
}
