package guru.springframework.spring5jokesappv2.controllers;

import guru.springframework.spring5jokesappv2.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
So a quick recap.
What I did in this video is we went and created the controllers package.
I added in a Java class called Joke Controller.
I annotated it with the Spring stereotype of controller.
And then I set up a final property for the joke service, created a constructor,
which will initialize the joke service. So remember best practice is
to code to an interface for Dependency Injection.
And then in this we are declaring that variable is final so we can construct the class.
And then with the constructor we are initializing the joke service and
by having it final can never be changed by something else in the class.
And finally, on line 22 there we are doing the show joke.
This is a method that's going to get invoked when we come into the context
that we have to request mapping.
You can see the two properties that we set there, slash and an empty string.
So this is going to go in for the root.
And then very simple.
All we are doing is we're adding in an attribute to the model with the property of joke,
and then we'll add the joke string from the joke service and
then we return back the string index.
That's going to tell Spring MVC that we want to do the index view.
We will implement the index view in the next video.
 */


@Controller
public class JokeController {

    private final JokeService jokeService;

    @Autowired /* we can omit this because there is one constructor in the class */
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    /* view name returns in String  */
    public String showJoke(Model model){
        /* model is a map implementation, we are adding in a property with the string */
        model.addAttribute("jokes",jokeService.getJoke());
        return "index"; /* will be replaced with view */
    }
}
