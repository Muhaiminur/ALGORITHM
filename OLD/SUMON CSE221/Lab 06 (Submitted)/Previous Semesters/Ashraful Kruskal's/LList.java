public class LList
{
  public Node head;
  public int size;
  public LList()
  {
    head = new Node(0,0,null);
    size = 0;
  }
  public void add(int n,int w)
  {
    Node temp = new Node(n,w,null);
    temp.next = head.next;
    head.next = temp;
    size++;
  }
  public Node pek(int n)
  {
    Node temp = head.next;
    Node tem = head;
    int t = size;
    while(t>0)
    {
      if(temp.nodNum == n)
      {
        tem.next = temp.next;
        size--;
        return temp;
      }
      tem = tem.next;
      temp = temp.next;
      t--;
    }
    return null;
  }
  public Node peak()
  {
    Node temp = head.next;
    if(head.next!=null)
    {
      head.next = head.next.next;
      size--;
      return temp;
    }
    else
    {
      return null;
    }
  }
  public int size()
  {
    return size;
  }
  public String toString()
  {
    String s = "";
    int t = size;
    Node temp = head.next;
   while(t!=0)
   {
     s = s+temp.nodNum+"|"+temp.weight+" --- ";
     temp = temp.next;
     t--;
   }
   return s;
  }
}