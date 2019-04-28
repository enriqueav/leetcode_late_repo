# https://leetcode.com/problems/time-based-key-value-store/
class TimeMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.timestamps_key = {}
        self.key_value = {}
        
    def binarySearch(self, row, target, ini, end):
        if ini>end:
            return ini-1
        mid = int((ini+end)/2)
        
        if row[mid] == target:
            return mid
        elif row[mid] > target:
            return self.binarySearch(row, target, ini, mid-1)
        else:
            return self.binarySearch(row, target, mid+1, end)
         

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.timestamps_key:
            self.timestamps_key[key] = []
            self.key_value[key] = []
            
        self.timestamps_key[key].append(timestamp)
        self.key_value[key].append(value)

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.timestamps_key:
            return ""
        timestamps = self.timestamps_key[key]
        index = self.binarySearch(timestamps,
                                  timestamp,
                                  0, 
                                  len(timestamps)-1)
        if index == -1:
            return ""
        result = self.key_value[key][index]
        return result


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)

# RESULT
# Runtime: 656 ms, faster than 7.73% of Python3 online submissions for Time Based Key-Value Store.
# Memory Usage: 56.8 MB, less than 64.71% of Python3 online submissions for Time Based Key-Value Store.