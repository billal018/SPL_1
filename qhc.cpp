#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int t;
    cin >> t;
    while (t--) 
    {
       int n,i=0;
       cin>>n;
       int tmp=n;
       int count=0;
       while(n!=0)
       {
        n/=10;
        tmp+=n;
        i++;
       }
       cout<<tmp<<endl;
    }
    return 0;
}
