package main

import "fmt"

func floodFill(image [][]int, sr int, sc int, newColor int) [][]int {
	rows := len(image)
	cols := len(image[0])
	startColor := image[sr][sc]

	if startColor == newColor {
		return image
	}

	var dfs func(r, c int)

	dfs = func(r, c int) {
		if r < 0 || r >= rows || c < 0 || c >= cols {
			return
		}
		if image[r][c] != startColor {
			return
		}

		image[r][c] = newColor
		dfs(r+1, c)
		dfs(r-1, c)
		dfs(r, c+1)
		dfs(r, c-1)

	}

	dfs(sr, sc)
	return image
}

func main() {
	image := [][]int{
		{1, 1, 1},
		{1, 1, 0},
		{1, 0, 1},
	}

	sr := 1
	sc := 1
	newColor := 2

	result := floodFill(image, sr, sc, newColor)

	for _, row := range result {
		fmt.Println(row)
	}
}
