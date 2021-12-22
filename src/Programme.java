import com.jdbc.crud.*;

public class Programme {
    public static void main(String[] args) {
        System.out.println("schema HeroManagement has been created");
        // create table Hero (run only once)
        CreateTable.dropSchema();
        CreateTable.createTableHero();

        // C
        Create.create();

        // R
        Read.getAllHero();

        // U
        Update.update();

        // D
//        Delete.delete();

        // find by id
        int id = 1;
        Search.findById(id);
    }
}
