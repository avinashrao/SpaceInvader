
import java.util.ArrayList;

public class BlockManager
{
    public static ArrayList<Block> barrier = new ArrayList<Block>();

    public static void initialize()
    {
        for( int i = 50; i<120; i=i+4){
            for (int j = 300;j<320; j=j+4) 
            {
                barrier.add(new Block(i,j));
            }
        }

        for( int i = 160; i<240; i=i+4){
            for (int j = 300;j<320; j=j+4) 
            {
                barrier.add(new Block(i,j));
            }
        }

        for( int i = 280; i<350; i=i+4){
            for (int j = 300;j<320; j=j+4) 
            {
                barrier.add(new Block(i,j));
            }
        }
    }
}
