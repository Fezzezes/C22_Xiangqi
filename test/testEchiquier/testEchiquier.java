package testEchiquier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xiangqi.echiquier.Echiquier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testEchiquier {

    Echiquier echiquier;

    @BeforeEach
    public void beforeEach()
    {echiquier = new Echiquier();}

    @Test
    public void constructeur(){
    }
}
