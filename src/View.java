import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class View {

    private View() {
    }

    static void renderText(String text) {
        System.out.println(text);
    }

    static void renderImage(File image) {
        try (BufferedReader imageFeed = new BufferedReader(new FileReader(image))) {
            String imageLine;

            while ((imageLine = imageFeed.readLine()) != null) {
                System.out.println(imageLine);
            }
        } catch (Exception e) {
            View.renderText(e.getMessage());
        }
    }
}