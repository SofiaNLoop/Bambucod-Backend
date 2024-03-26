# Group 04 collaborators:
- Raquel Sofia Neira
- Edwin Rojas
- Ruben Duarte
## Peaku cohort-11 project

- 💻 Experience in HTML5, CSS3, Bootsrap5
- using responsive mobile first
- 🎨 Bootstrap concepts: Grid, container, row, components and flexbox


you can use this coding solutions, to test the first and second execercise:

Two-sum
```
const hashTable = {};

for(let i=0; i<nums.length; i++){
	let value = target - nums[i]
	if(!(value in hashTable)){
		hashTable[nums[i]]=i
	} else{
		return [hashTable[value],i]
	}
}
```
valid-parentheses
```
while (
          s.indexOf('()') !== -1 ||
          s.indexOf('{}') !== -1 ||
          s.indexOf('[]') !== -1
      ) {

          s = s
              .replace('()', '')
              .replace('{}', '')
              .replace('[]', '');
      }
  
      return !s.length;