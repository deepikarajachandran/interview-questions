package com.company;

public class smallbigmatrix {


    public static void main(String[] args) {
        int[][] a={{1,0,0},{1,1,4},{6,2,4}};
        int[][] b={{1,0},{1,1}};
        int m=3,n=3;
        int c=2,d=2;
        int k,p = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i][j]==b[0][0])
                {
                    exi:
                    for(k=0;k<c;k++)
                    {
                        for(p=0;p<d;p++)
                        {
                            if(a[i+k][j+p]!=b[k][p])
                            {
                                break exi;
                            }
                        }
                    }
                    if(k==c && p==d)
                    {
                        System.out.println("true");
                        int x=(i+k-1);
                        int y=(j+p-1);
                        System.out.println("from "+i+","+j+" to "+x+","+y);
                        return;
                    }
                }
            }
        }
        System.out.println("false");
    }
}
