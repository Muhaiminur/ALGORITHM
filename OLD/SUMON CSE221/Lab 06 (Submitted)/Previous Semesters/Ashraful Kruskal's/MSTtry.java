import java.util.*;
public class MSTtry
{
  public static void main(String[]args)
  {
    Scanner take = new Scanner(System.in);
    int gn = take.nextInt();
    LList []a = new LList[gn+1];
    int []we = new int[gn+1];
    for(int i = 0;i<a.length;i++)
    {
      a[i] = new LList();
    }
    try
    {
      int n = gn*(gn-1)/2;
      while(n!=0&&take.hasNext())
      {
        int u = take.nextInt();
        int v = take.nextInt();
        int w = take.nextInt();
        a[u].add(v,w);
        a[v].add(u,w);
        n--;
      }
    }
    catch(InputMismatchException e){}
    for(int i = 1;i<a.length;i++)
    {
      System.out.println(i+"|-->"+a[i].toString());
    }
    System.out.println();
    SortList sl = new SortList();
    for(int i = 1;i<a.length;i++)
    {
      if(a[i].size()!=0)
      {
        while(a[i].size()!=0)
        {
          Node temp = a[i].peak();
          a[temp.nodNum].pek(i);
          sl.add(i,temp.nodNum,temp.weight);
        }
      }
    }
    
    NNode []s = sl.toArray();
    System.out.println("{u,v} [w]");
    for(int i = 0;i<s.length;i++)
    {
      System.out.println("{"+s[i].u+","+s[i].v+"} ["+s[i].w+"]");
    }
    SortList mst = new SortList();
    ArrayList<Integer> al = new ArrayList<Integer>();
    for(int i = 0;i<s.length;i++)
    {
      if(i == 0)
      {
        al.add(s[i].u);
        al.add(s[i].v);
        mst.add(s[i].u,s[i].v,s[i].w);
      }
      else
      {
        if(!al.contains(s[i].u) && !al.contains(s[i].v))
        {
          al.add(s[i].u);
          al.add(s[i].v);
          mst.add(s[i].u,s[i].v,s[i].w);
        }
        else if(al.contains(s[i].u) && !al.contains(s[i].v))
        {
          al.add(s[i].v);
          mst.add(s[i].u,s[i].v,s[i].w);
        }
        else if(!al.contains(s[i].u) && al.contains(s[i].v))
        {
          al.add(s[i].u);
          mst.add(s[i].u,s[i].v,s[i].w);
        }
      }
    }
    System.out.println(al.toString());
    NNode []s1 = mst.toArray();
    System.out.println("{u,v} [w]");
    for(int i = 0;i<s1.length;i++)
    {
      System.out.println("{"+s1[i].u+","+s1[i].v+"} ["+s1[i].w+"]");
    }
  }
}