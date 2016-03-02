import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by chris on 2016/03/02.
 */
public class AGMessengerList <T>  extends LinkedList<T>{

    public AGMessengerList() {
    }

    public AGMessengerList(Collection<? extends T> c) {
        super(c);
    }

    //Here I was just being fency :)
    public boolean add(T object){
        if (object instanceof  UserDTO) {
            if(super.contains(object)){
                ((UserDTO)(super.get(indexOf(object)))).doDeepCopyOfFollers((UserDTO)object);
                return true;
            }
            return super.add(object);
        }else{
            return super.add(object);
        }
    }

    public boolean addAll( Collection<? extends T> c) {
       for(T o : c) {
           this.add(o);
       }
        return true;
    }
}
