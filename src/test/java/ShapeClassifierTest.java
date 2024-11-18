import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
// import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;


public class ShapeClassifierTest {

    @Test
    void testEvaluateGuess_CorrectAllGuesses() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Equilateral,Large,Yes,100,100,100";
        String result = classifier.evaluateGuess(input);
        assertEquals("Wrong Size,Wrong Even/Odd", result);
    }

    @Test
    void testEvaluateGuess_IncorrectShapeGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Scalene,Large,Yes,100,100,100";
        String result = classifier.evaluateGuess(input);
        assertTrue(result.startsWith("No:"));
        assertTrue(result.contains("Suggestion=Equilateral"));
    }

    @Test
    void testEvaluateGuess_IncorrectSizeGuess() {
        ShapeClassifier classifier = new ShapeClassifier();
        String input = "Equilateral,Small,Yes,100,100,100"; 
        String result = classifier.evaluateGuess(input);
        assertEquals("Yes: Wrong Even/Odd", result);
    }

}
