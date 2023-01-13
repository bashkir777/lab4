package Interfaces;

import AbstractClasses.Human;
import Errors.InteractionImpossible;

public interface Interactive {
    void interaction(Human human) throws InteractionImpossible;
}
