public class TaggedLinkedList<E> extends LinkedList<E> implements TaggedLinkedListInterface<E>, Iterable<E> {
    private char tagLetter;

    public TaggedLinkedList(char tagLetter) {
        this.tagLetter = tagLetter;
    }
    @Override
    public char getTagLetter() {
        return tagLetter;
    }
}
