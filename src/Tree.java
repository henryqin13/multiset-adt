import java.util.ArrayList;
import java.util.List;

public class Tree {
    // Object is the <Any> type in Java
    private Object root;
    private List<Tree> subtrees;

    public Tree(Object root) {
        this.root = root;
        // no subtrees provided
        this.subtrees = new ArrayList<>();
    }

    public Tree(Object root, ArrayList<Tree> subtrees){
        this.root = root;
        // subtrees provided
        this.subtrees = subtrees;
    }

    public boolean is_empty(){
        return this.root == null;
    }

//    public static void main(String[] args) {
//        Tree t1 = new Tree("123");
//        System.out.println(t1.is_empty());
//    }
}
