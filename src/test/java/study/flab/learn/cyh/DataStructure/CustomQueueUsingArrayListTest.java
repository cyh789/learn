package study.flab.learn.cyh.DataStructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

import static org.assertj.core.api.Assertions.*;

class CustomQueueUsingArrayListTest {

    private CustomQueueUsingArrayList cQueue;
    private Queue sQueue;
    private String sMsg;

    @BeforeEach
    void setUp() {
        cQueue = new CustomQueueUsingArrayList();
        sQueue = new ArrayDeque();
    }

    @Test
    void testQueue() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("첫 번째 요소"); // "첫 번째 요소"
        deque.add("두 번째 요소"); // "첫 번째 요소", "두 번째 요소"
        deque.push("세 번째 요소"); // "세 번째 요소", "첫 번째 요소", "두 번째 요소"

        sMsg = "[세 번째 요소, 첫 번째 요소, 두 번째 요소]";
        Assertions.assertThat(deque.toString()).isEqualTo(sMsg);
    }

    @Test
    void isEmpty() {
        assertThat(sQueue.isEmpty()).isTrue();
        sQueue.add("1번");
        assertThat(sQueue.isEmpty()).isFalse();

        assertThat(cQueue.isEmpty()).isTrue();
        cQueue.enqueue("1번");
        assertThat(cQueue.isEmpty()).isFalse();
    }

    @Test
    void enqueue() {
        sQueue.add("1번");
        sQueue.add("2번");
        sMsg = "[1번,2번]";
        assertThat(sQueue.toString().replaceAll(" ","")).isEqualTo(sMsg);

        cQueue.enqueue("1번");
        cQueue.enqueue("2번");
        sMsg = "1번,2번";
        assertThat(cQueue.toString().replaceAll(" ","")).contains(sMsg);
    }

    @Test
    void dequeue() {
        sQueue.add("1번");
        sQueue.add("2번");
        sQueue.add("3번");
        sMsg = "1번";
        assertThat(sQueue.remove().toString().replaceAll(" ","")).isEqualTo(sMsg);
        sMsg = "[2번,3번]";
        assertThat(sQueue.toString().replaceAll(" ","")).isEqualTo(sMsg);

        cQueue.enqueue("1번");
        cQueue.enqueue("2번");
        cQueue.enqueue("3번");
        sMsg = "1번";
        assertThat(cQueue.dequeue().toString().replaceAll(" ","")).contains(sMsg);
        sMsg = "2번,3번";
        assertThat(cQueue.toString().replaceAll(" ","")).contains(sMsg);
    }

    @Test
    void peek() {
        sQueue.add("1번");
        sQueue.add("2번");
        sMsg = "1번";
        assertThat(sQueue.peek().toString().replaceAll(" ","")).isEqualTo(sMsg);

        cQueue.enqueue("1번");
        cQueue.enqueue("2번");
        sMsg = "1번";
        assertThat(cQueue.peek().toString().replaceAll(" ","")).contains(sMsg);
    }
}