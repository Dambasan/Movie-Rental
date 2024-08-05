package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public Actor getActorById(Long id) {
        return actorRepository.findById(id).orElse(null);
    }

    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public List<Movie> getMovieByActorId(Long id) {
        return actorRepository.findById(id).map(Actor::getMovies).orElse(null);
    }
    public Actor updateActor(Actor actor, Long id) {
        Actor existingActor = actorRepository.findById(id).orElse(null);
        if (existingActor != null) {
            existingActor.setMovies(actor.getMovies());
            existingActor.setAge(actor.getAge());
            existingActor.setBio(actor.getBio());
            return actorRepository.save(existingActor);
        }else {
            return null;
        }
    }

    public void deleteActorById(Long id) {
        actorRepository.deleteById(id);
    }
}
