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

    public Tree(Object root, ArrayList<Tree> subtrees) {
        this.root = root;
        // subtrees provided
        this.subtrees = subtrees;
    }

    public boolean is_empty() {
        /**
         * Return true iff <this> does not contain a root.
         */
        return this.root == null;
    }

    public int length() {
        /**
         * Return the length of the <Tree>.
         */
        if (this.is_empty()) {
            return (0);
        } else {
            int size = 1;
            for (Tree subtree : this.subtrees) {
                size += subtree.length();
            }
            return (size);
        }
    }

    public int count(Object item) {
        /**
         * Return the number of occurrence of <item> in this Tree.
         */
        if (this.is_empty()){
            return(0);
        } else {
            int num = 0;
            if (this.root == item){
                num += 1;
            }
            for (Tree subtree: this.subtrees){
                num += subtree.count(item);
            }
            return(num);
        }
    }


    public static void main(String[] args) {
        Tree t1 = new Tree("123");
        ArrayList<Tree> list = new ArrayList<Tree>();
        list.add(t1);
        Tree t2 = new Tree("123", list);
        System.out.println(t2.count("123"));
    }

//  no idea how to do this
    public String __str__() {
        return this._str_indented();
    }

    private String _str_indented(int depth) {
        if (this.is_empty()) {
            String p = "";
            return p;
        }
        else {
            String k = "  ";
            String change_line = "\n";
            String repeated = new String(new char[depth]).replace("\0", k);
            String s = repeated + this.root.toString() + change_line;
            for (Tree subtree: this.subtrees){
                s += subtree._str_indented(depth + 1);
            }
            return s;
        }
    }

    private String _str_indented() {
        int d = 0;
        if (this.is_empty()) {
            String p = "";
            return p;
        }
        else {
            String k = "  ";
            String change_line = "\n";
            String repeated = new String(new char[d]).replace("\0", k);
            String s = repeated + this.root.toString() + change_line;
            for (Tree subtree: this.subtrees){
                s += subtree._str_indented(d + 1);
            }
            return s;
        }
    }

    // check how to make a tuple, and don't forget to create the average helper
    public float average(){
        if (this.is_empty()) {
            return 0.0F;
        }
        else{
            Pair<int, int> my_tuple = Pair.with (this._average_helper());
            return my_tuple.getValue(0) / my_tuple.getValue(1);
        }
    }
}
