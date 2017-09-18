import java.util.List;

public class Separate2KGroup {
		
	public boolean separate(List<Integer> list, int k){
		// Your resolution: 
		// Time complexity:  O(n^k)
		// Space complexity: O(n)
		if(k==1) return true;
		int n = list.size();
		if(k>n) return false; //if total number of group is more than list's size, division is not possible
		
		int sum = 0;// sum of list
		for(int i=0;i<n;i++)sum +=list.get(i);
		if(sum%k!=0) return false; //if sum cannot divided by k, then we can not get k group subset.
		
		int subsum = sum/k; // target sum of each group
		int[] subleft = new int[k]; // sum of each group
		boolean[] isUsed= new boolean[n];
		
		for(int i=0;i<k;i++){
			subleft[i] = 0;
		}
		return canSeparate(list,subsum,subleft,isUsed,k,n,0,n-1);
	}
	
	public boolean canSeparate(List<Integer> list, int subsum, int[] subleft, boolean[] used, int k, int n,int curIdx, int limitIdx){
		for(int i=limitIdx;i>=0;i--){
			if(used[i])continue;
			int tmp = subleft[curIdx]+list.get(i);
			used[i] = true;
			subleft[curIdx] += list.get(i);
			if(tmp==subsum){
				if(curIdx ==k-2) return true;
				boolean flag = canSeparate(list,subsum,subleft,used,k,n,curIdx+1,limitIdx);
				used[i] = false;
				subleft[curIdx] -= list.get(i);
				if(flag) return true;
			}
			else{
				boolean flag = canSeparate(list,subsum,subleft,used,k,n,curIdx,i-1);
				used[i] = false;
				subleft[curIdx] -= list.get(i);
				if(flag) return true;
			}
		}
		return false;
	}
}

