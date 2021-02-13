package third;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@TestInstance(value=PER_CLASS)
public class ModelTest {

    private Actor arthur, leftHead, rightHead;

    @BeforeEach
    public void init() {
        this.arthur = new Actor("Артур", 2);
        arthur.addAction(new Enter());
        arthur.addAction(new Realize());
        this.leftHead = new Actor("Левая голова", 2);
        leftHead.addAction(new FallApart());
        leftHead.addAction(new PutFeet());
        leftHead.addAction(new Smile());
        this.rightHead = new Actor("Правая голова", 2);
        rightHead.addAction(new FallApart());
        rightHead.addAction(new PutFeet());
        rightHead.addAction(new PokeAround());
    }

    @Test
    public void nonExistentActionTest() {
        assertThrows(IllegalArgumentException.class, () -> {arthur.doAction(2);});
    }

    @Test
    public void tensionTest() {
        arthur.doAction(0);
        leftHead.doAction(0);
        rightHead.doAction(0);
        leftHead.doAction(1);
        rightHead.doAction(1);
        rightHead.doAction(2);
        leftHead.doAction(2);
        arthur.doAction(1);

        assertEquals(10, arthur.getTension());
        assertEquals(0, leftHead.getTension());
        assertEquals(2, rightHead.getTension());
    }

    @Test
    public void tensionBoundsTest() {
        arthur.addAction(new Relax());

        arthur.doAction(1);
        arthur.doAction(1);
        assertEquals(10, arthur.getTension());

        arthur.doAction(2);
        arthur.doAction(2);
        assertEquals(0, arthur.getTension());
    }

}
