
import java.util.ArrayList;

public class BlockManager// comment code for BlcokManager class is identical to that found in AlienManager. 
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

        for( int i = 180; i<220; i=i+4){
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
        public static void initialize(ArrayList<Block> b)// initialize method when classed will populate araylist with aliens. 
    {
        barrier=b;
    }
    
}
