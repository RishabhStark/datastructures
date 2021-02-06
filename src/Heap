import java.util.Scanner;

/**
 * Heap
 */
 class Heap {

    private int[] arr;
    private int maxSize,size;
    
    public Heap(int maxSize) {
        this.maxSize=maxSize;
        this.size=-1;
        arr=new int[maxSize];
    }


    private int parent(int pos) 
    { 
        return pos / 2; 
    } 

    public void insert(int e) {
        if(size<maxSize) {
            arr[++size]=e;
            int current=size;
            while (arr[current] > arr[parent(current)]) { 
                swap(current, parent(current)); 
                current = parent(current); 
            } 
           
        }

        else {
            System.out.println("heap overflow");
        }
    }


    private void swap(int fpos, int spos) 
    { 
        int tmp; 
        tmp = arr[fpos]; 
        arr[fpos] = arr[spos]; 
        arr[spos] = tmp; 
    } 


    public void heapify(int i) {
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<=size && arr[left]>arr[largest] ) {
            largest=left;
        }
        if(right<=size && arr[right]>arr[largest]) {
            largest=right;
        }
        if(largest!=i) {
            // swap largest with i
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            heapify(largest);
        }
    }

    public void buildHeap() {
        // last internal node
        int startIdx=(size/2)-1; 
        for (int i = startIdx; i >=0; i--) {
            heapify(i);
        }
    }

    public void printHeap() {
        for (int i = 0; i <= size; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void heapSort() {
        int s=size;
         for (int i = s; i > 0; i--) {
             swap(0, i);
             size--;
             heapify(0);
             
            
         }
         size=s;
    }

    public int extratMax() {
        int max=arr[0];
        arr[0]=arr[size--];
       heapify(0);
        return max;
    }


    public static void main(String[] args) {
        Heap heap=new Heap(11);
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int e=sc.nextInt();
            heap.insert(e);
        }
        heap.buildHeap();
        heap.printHeap();
        heap.heapSort();
        heap.printHeap();
    }


}
