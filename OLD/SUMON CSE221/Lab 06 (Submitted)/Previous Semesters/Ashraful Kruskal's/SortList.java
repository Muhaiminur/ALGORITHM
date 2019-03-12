public class SortList
{
  public NNode head;
  public int size;
  public SortList()
  {
    head = new NNode(0,0,0,null);
    size = 0;
  }
  public void add(int j,int k,int l)
  {
    NNode temp = new NNode(j,k,l,null);
    if(size == 0)
    {
      head.next = temp;
      size++;
    }
    else
    {
      NNode tem = head.next;
      NNode te = head;
      int i = size;
      while(i>0)
      {
        if(temp.w<=tem.w)
        {
          temp.next = tem;
          te.next = temp;
          size++;
          return;
        }
        tem = tem.next;
        te = te.next;
        i--;
      }
      te.next = temp;
      size++;
    }
  }
  public NNode[] toArray()
  {
    NNode[] s = new NNode[size];
    NNode temp = head.next;
    int i = 0;
    while(i<size)
    {
      s[i] = temp;
      temp = temp.next;
      i++;
    }
    return s;
  }
}